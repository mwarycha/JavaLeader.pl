package jersey;

import bingo.model.BingoRestModel;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class MyApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(BingoRestModel.class).to(BingoRestModel.class);
    }
}