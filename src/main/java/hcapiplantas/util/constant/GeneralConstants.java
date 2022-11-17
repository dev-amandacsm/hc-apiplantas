package hcapiplantas.util.constant;

public abstract class GeneralConstants {


    //regex patterns
    public static final String NOT_SPECIAL_CHARACTER_256_PATTERN = "^[\\wóáõãâêéúíç.,:;%\\d ]{0,256}$";
    public static final String NOT_SPECIAL_CHARACTER_60_PATTERN = "^[\\wóáõãâêéúíç.,:;%\\d ]{0,60}$";

    //constraints violation messages
    public static final String NOT_BLANK_MESSAGE = "O campo não pode estar em branco.";
    public static final String OUTSIDE_EXPECTED_PATTERN_MESSAGE = "O campo está fora do padrão esperado.";

    //exception messages
    public static final String DATA_ALREADY_EXISTS_MESSAGE = "O dado %s já está cadastrado.";
    public static final String DATA_NOT_FOUND_MESSAGE = "O dado com id %s não foi encontrado.";

    public static final String CATEGORY_NOT_FOUND_MESSAGE = "A categoria com id %s não foi encontrada.";
    public static final String RESTRICTION_NOT_FOUND_MESSAGE = "O grupo restritivo %s não foi encontrado.";
    public static final String SYMPTOM_NOT_FOUND_MESSAGE = "O sintoma %s não foi encontrado.";

}
