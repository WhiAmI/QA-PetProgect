package automation.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SmokeTest {
    @Test
    public void shouldVerifyBasicMath(){
        Assertions.assertEquals(4, 2+2);
    }

}
