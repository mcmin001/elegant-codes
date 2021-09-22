import com.elegant.codes.design.adapter.Adapter;
import com.elegant.codes.design.adapter.DC5V;
import org.junit.Test;

public class AdapterPatternTest {
    @Test
    public void adapterPatternTest(){
        DC5V dc5V = new Adapter();
        int voltage = dc5V.output5Voltage();
        System.out.println("适配器输出的电压为"  + voltage +"V");
    }
}
