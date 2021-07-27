package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.assertThat;

public class ConversionServiceTest {

    @Test
    void conversionService(){
        //등록
        //conversionService가 다 찾아서 해결해줌... 어딘가에 conversionService만 주입받아서 사용하면 된다...
        //등록할때 해당 Converter이름을 다 알아야한다.
        //사용자 입장에서는 몰라도 괜찮다...
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        //사용
        assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
        assertThat(conversionService.convert(10, String.class)).isEqualTo("10");

        IpPort result = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(result).isEqualTo(new IpPort("127.0.0.1",8080));

        String result2 = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
        assertThat("127.0.0.1:8080").isEqualTo(result2);


    }

}
