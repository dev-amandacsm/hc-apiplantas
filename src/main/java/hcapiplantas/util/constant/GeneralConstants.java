package hcapiplantas.util.constant;

public abstract class GeneralConstants {
    //host
    public static final String LOCAL_HOST = "http://localhost:8080/";
    public static final String DEV_HOST = "http://testes:8080/";

    //regex patterns
    public static final String NOT_SPECIAL_CHARACTER_256_PATTERN = "^[\\wóáôàõãâêéúíç.,:;%\\d ]{0,256}$";
    public static final String NOT_SPECIAL_CHARACTER_60_PATTERN = "^[\\wóôáàõãâêéúíç.,:;%\\d ]{0,60}$";
    public static final String NOT_SPECIAL_CHARACTER_45_PATTERN = "^[\\wóáàôõãâêéúíç.,:;%\\d ]{0,45}$";


    public static final String STATE_ACRONYM_CHARACTER_2_PATTERN = "^[A-Z]{2,2}$";

    //constraints violation messages
    public static final String NOT_BLANK_MESSAGE = "O campo não pode estar em branco.";
    public static final String OUTSIDE_EXPECTED_PATTERN_MESSAGE = "O campo está fora do padrão esperado.";

    //exception messages
    public static final String DATA_ALREADY_EXISTS_MESSAGE = "O dado %s já está cadastrado.";
    public static final String USER_ALREADY_EXISTS_MESSAGE = "Usuário já cadastrado.";
    public static final String DATA_NOT_FOUND_MESSAGE = "O dado com id %s não foi encontrado.";

    public static final String DISTRICT_NOT_FOUND_MESSAGE = "Bairro não encontrado";

    public static final String CATEGORY_NOT_FOUND_MESSAGE = "A categoria %s não foi encontrada.";
    public static final String RESTRICTION_NOT_FOUND_MESSAGE = "O grupo restritivo %s não foi encontrado.";
    public static final String SYMPTOM_NOT_FOUND_MESSAGE = "O sintoma %s não foi encontrado.";

}
