package expressions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs {

    int cucumbers;
    double cucumberSlices;
    float floatingSlices;

    // + Generated snippet contains cucumber expression {int}
    // - IntelliJ gives an error on {int} saying "Number expected"
    // Question: how does it "know: to generate expressions not regex? Could I still generate regex if I prefer?
//    @Given("I have {int} cucumbers in my belly")
//    public void i_have_cucumbers_expressions_in_my_belly(int integer) {
//        cucumbers = integer;
//    }

    // + Nice; I can replace it with a regex step and use regex combined with expressions!
    // (My question was: Can I still use regex? (and how?) Or will all my existing tests break?)
    @Given("^I have (\\d+) cucumbers in my belly$")
    public void i_have_cucumbers_in_my_belly(int integer) {
        cucumbers = integer;
    }

    // Generated snippet with double has two arguments, both ints (I'm assuming it's the numbers before and after the decimal)
    // - Running it leads to cucumber.runtime.CucumberException: Arity mismatch: Step Definition 'expressions.StepDefs.i_have_cucumbers_in_my_belly(int,int)
//    @Given("I have {double} cucumbers in my belly")
//    public void i_have_cucumbers_in_my_belly(int arg1, int arg2) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }

    // Workaround: Changing argument to double works (but generated snippet really should be correct)
    // Question: documentation gives example using float, but double is generated. This should be consistent?
//    @Given("I have {double} cucumbers in my belly")
//    public void i_have_cucumbers_in_my_belly(double slices) {
//        cucumberSlices = slices;
//    }

    // Having both a step def with double and float gives cucumber.runtime.AmbiguousStepDefinitionsException:
    // "I have 42.5 cucumbers in my belly" matches more than one step definition:
    // (Which is as expected :)
    // Using float instead of double works.
    @Given("I have {float} cucumbers in my belly")
    public void i_have_cucumbers_in_my_belly(float slices) {
        floatingSlices = slices;
    }

    // Obviously it doesn't generate a step with {word} in it, because how would it know which word is my variable
    // Replacing with {word} AND adding an argument works
    // (if argument not added, throws "cucumber.runtime.CucumberException: Arity mismatch:" - as expected)
    @When("I test {word}")
    public void i_test_expressions(String word) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    // Hmm, somehow it doesn't recognize this step? (Replaced mulitple words from generated snippet with {string}
    @Then("my test should {string}")
    public void my_test_should_very_surely_pass(String multipleWords) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
