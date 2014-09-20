package rule.client;

import org.testng.annotations.Test;

import rule.client.model.Person;


public class RuleLoaderTest {

	@Test
	public void shouldInvokeDroolsWithExternalRules() throws Exception{
		RuleResource dsl = RuleLoader.loadDslFrom("http://localhost:3000/persistent/dsl");
		RuleResource dslr= RuleLoader.loadRuleFrom("http://localhost:3000/persistent/rule", "rule.client.model.Person");
		
		System.out.println("######## DSLs ############");
		System.out.println(dsl.getContent());
		
		System.out.println("\n\n######## RULES ############");
		System.out.println(dslr.getResourceName());
		System.out.println(dslr.getContent());
		
		RulesExecutor6 rulesExecutor6 = new RulesExecutor6(dsl, dslr);
		Person rocky = new Person("Rocky", "Philadelphia", 65);
		Person guilherme = new Person("Guilherme", "Philadelphia", 35);
		Person SilvioSantos = new Person("Silvio Santos", "Philadelphia", 35);
		rulesExecutor6.execute(rocky);
		rulesExecutor6.execute(guilherme);
		rulesExecutor6.execute(SilvioSantos);
		System.out.println(rocky);
	}
}
