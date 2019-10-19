package pl.javaleader.statemachine.configurations;

import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import java.util.Arrays;
import java.util.HashSet;
import org.springframework.statemachine.guard.Guard;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.context.annotation.Bean;

@Configuration
@EnableStateMachine
public class SimpleStateMachineConfiguration 
  extends StateMachineConfigurerAdapter<String, String> {

    @Override
    public void configure(StateMachineStateConfigurer<String, String> states)
      throws Exception {

        states
          .withStates()
          .initial("SI")
          .fork("SFork")
          .join("SJoin")
          .end("SF")
          .junction("J")

          .states(new HashSet<String>(Arrays.asList("S1", "S2"))).state("S1", countNumbersOfInvokeStateS1())
            .and()
            .withStates()
                .parent("SFork")
                .initial("Sub1-1")
                .end("Sub1-2")
            .and()
            .withStates()
                .parent("SFork")
                .initial("Sub2-1")
                .end("Sub2-2");
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<String, String> config) throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(new StateMachineListener());
    }

@Override
public void configure(
  StateMachineTransitionConfigurer<String, String> transitions)
  throws Exception {
    transitions.withExternal()
      .source("SI").target("S1").event("E1").guard(guard()).and()
      .withExternal()
      .source("S1").target("J").event("E2").action(printStateIdAction()).and()
            .withExternal()

            // junction

            .and()
            .withJunction()
            .source("J")
            .first("S2"  , firstGuard())
            .then("SFork", secondGuard())
            .last("SF")

            // fork

            .and()
            .withExternal()
            .source("S2").target("SF").event("E3").and()
            .withFork()
                .source("SFork")
                .target("Sub1-1")
                .target("Sub2-1")

            // join

            .and()
                .withJoin()
                    .source("Sub1-2")
                    .source("Sub2-2")
                    .target("SJoin")

            .and()
            .withExternal()
            .source("SI").target("SFork").event("E1")

            .and().withExternal()
                .source("Sub1-1").target("Sub1-2").event("sub1")
                .and().withExternal()
                .source("Sub2-1").target("Sub2-2").event("sub2");
}

    @Bean
    public Guard<String, String> firstGuard() {
        System.out.println("firstGuard");
        return ctx -> false;
    }

    @Bean
    public Guard<String, String> secondGuard() {
        System.out.println("secondGuard");
        return ctx -> true;
    }

    @Bean
    public Action<String, String> printStateIdAction() {
        return ctx -> System.out.println(ctx.getTarget().getId());
    }

    @Bean
    public Guard<String, String> guard() {
        return ctx -> (int) ctx.getExtendedState()
                .getVariables()
                .getOrDefault("counter", 0) >= 0;
    }

    @Bean
    public Action<String, String> countNumbersOfInvokeStateS1() {
        return ctx -> {
            int approvals = (int) ctx.getExtendedState().getVariables()
                    .getOrDefault("counter", 0);
            approvals++;
            ctx.getExtendedState().getVariables()
                    .put("counter", approvals);

            System.out.println("counter " + approvals);
        };
    }
}