package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ConverterTest {

    @Test
    void stringToInterger(){
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer convert = converter.convert("22");
        assertThat(22).isEqualTo(convert);
    }

    @Test
    void IntegerToString(){
        IntegerToStringConverter conv = new IntegerToStringConverter();
        String result = conv.convert(333);
        assertThat("333").isEqualTo(result);
    }

    @Test
    void stringIpPort(){
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort source = new IpPort("127.0.0.1", 8080);
        String result = converter.convert(source);
        assertThat("127.0.0.1:8080").isEqualTo(result);
    }

    @Test
    void IpPortString(){
        StringToIpPortConverter converter = new StringToIpPortConverter();
        IpPort result = converter.convert("127.0.0.1:8080");
        System.out.println("result = " + result);
        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
    }





}
