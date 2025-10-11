package practica5.ej1;

@SuppressWarnings({"deprecation"})
public class TestAnotaciones {
    public static void main(String[] args) throws Exception{
        new TestAnotaciones().testearYa();
    }

    public void testearYa(){
        TestDeprecated t2 = new TestDeprecated();
        t2.hacer();
    }
}
