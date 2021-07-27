package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {


    //넘어오는 값이 다 String이므로 변환이 필요
    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request){
        String data = request.getParameter("data");//문자 타입으로 조회
        Integer intValue = Integer.valueOf(data);
        System.out.println("intValue = " + intValue);
        System.out.println("intValue1 = " + intValue);
        return "ok";
    }

    // Spring의 타입 변환... -> 타입 컨버터...
    //String에서 제공하는데 Requestparam을 사용하면 스프링이 중간에서 타입변환을 해줘서 가능하다...
    //Model Attribute도 PathVAriable도 다 String -> 맞는 타입으로 형변환 해서 가져다 준다.. !!
    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data){
        System.out.println("data = " + data);
        return "ok2";
    }

    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort ipPort){
        System.out.println("ipPort.getIp() = " + ipPort.getIp());
        System.out.println("ipPort.getPort() = " + ipPort.getPort());
        return "ok3";
    }


}
