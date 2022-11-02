package hcapiplantas.util.constant;

public abstract class GeneralConstants {


    //regex patterns
    public static final String NOT_SPECIAL_CHARACTER_256_PATTERN = "^[a-zA-Zóáõãâêúí.,;ç ]{0,256}$";
    public static final String NOT_SPECIAL_CHARACTER_60_PATTERN = "^[a-zA-Zóáõãâêúíç ]{0,60}$";

    //constraints violation messages
    public static final String NOT_BLANK_MESSAGE = "O campo {field} não pode estar em branco.";
    public static final String OUTSIDE_EXPECTED_PATTERN_MESSAGE = "O campo {field} está fora do padrão esperado.";


    public static final String DATA_ALREADY_EXISTS_MESSAGE = "O dado %s já está cadastrado.";
}
