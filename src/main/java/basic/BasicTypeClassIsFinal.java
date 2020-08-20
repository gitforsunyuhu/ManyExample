package basic;

/**
 * 基础类型的包装类全部都是 final类型的
 */
public class BasicTypeClassIsFinal {
    Integer integer = new Integer(10);
    Boolean aBoolean = new Boolean(true);
    Character character = new Character('a');
    Short aShort = new Short((short) 10);
    Float aFloat = new Float(10.1);
    Double aDouble = new Double(101.2);
    Byte aByte = new Byte((byte) 10);
    Long aLong = new Long(100);
    String  string =new String("121e1231");
    StringBuffer sb = new StringBuffer("ssss");
    StringBuilder stringBuilder = new StringBuilder("aaaa");
    /**
     * 以上都是final类型的，不可以继承
     */
}
