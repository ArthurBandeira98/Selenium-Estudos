package A_Testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ A_TesteGoogle.class, D_CadastroFormulario.class })
public class K_SuiteTest {
	// TESTE DE MAIS DE UMA CLASSE AO MESMO TEMPO
}
