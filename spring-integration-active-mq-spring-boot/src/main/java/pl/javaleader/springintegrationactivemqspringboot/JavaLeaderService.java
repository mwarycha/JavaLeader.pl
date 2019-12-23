package pl.javaleader.springintegrationactivemqspringboot;

import org.springframework.stereotype.Service;

@Service
public class JavaLeaderService {
    public void printMsg(String msg){
        System.out.println("################################");
        System.out.println("##  JavaLeader " + msg + "!!!"   );
        System.out.println("################################");
    }
}