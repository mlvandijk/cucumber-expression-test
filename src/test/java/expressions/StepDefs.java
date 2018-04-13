package expressions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.math.BigDecimal;
import java.math.BigInteger;

public class StepDefs {

    // Question: how does it "know: to generate expressions not regex? Could I still generate regex if I prefer?

    int cucumbers;
    long longCucumbers;
    double doubleSlices;
    float floatingSlices;
    BigDecimal bigDecimalSlices;

    // 1. Using numbers that are integers:
    // Can use only one integer type, otherwise AmbiguousStepDefinitionsException is thrown (as expected)

//    // + Generated snippet contains cucumber expression {int}
    @Given("I have {int} cucumber(s) in my belly/stomach")
    public void i_have_cucumbers_expressions_in_my_belly(int number) {
        cucumbers = number;
    }

    // - Using {byte} doesn't work (according to the docs it should)
    // Expected result: Step definition is found
    // Actual result: Cucumber suggests snippets with an {int}
//    @Given("I have {byte} cucumber(s) in my belly/stomach")
//    public void i_have_byte_cucumbers_expressions_in_my_belly(byte number) {
//        cucumbers = number;
//    }

    // + Using {short} works!
//    @Given("I have {short} cucumber(s) in my belly/stomach")
//    public void i_have_short_cucumbers_expressions_in_my_belly(short number) {
//        cucumbers = number;
//    }

    // + Using {long} works (although only if variable is also a long - as expected in Java)!
//    @Given("I have {long} cucumber(s) in my belly/stomach")
//    public void i_have_long_cucumbers_expressions_in_my_belly(long number) {
//        longCucumbers = number;
//    }

    // + Nice; I can replace it with a regex step and use regex combined with expressions!
    // Also still works with cucumbers? to match cucumber/cucumbers
    // I do have to match belly and stomach separately, which is another improvement in cucumbers expressions!
    // (My question was: Can I still use regex? (and how?) Or will all my existing tests break?)
    // Also I noticed that {int} does match negative numbers, while (\\d+) does not.
//    @Given("^I have (\\d+) cucumbers? in my belly$")
//    public void i_have_cucumbers_in_my_belly(int integer) {
//        cucumbers = integer;
//    }
//
//    @Given("^I have (\\d+) cucumbers? in my stomach")
//    public void i_have_cucumbers_in_my_stomach(int integer) {
//        cucumbers = integer;
//    }

    // 2. Using decimal numbers

    // Question: documentation gives example using float, but double is generated. This should be consistent?
    @Given("I have {double} cucumbers in my belly")
    public void i_have_cucumbers_in_my_belly(double double1) {
        doubleSlices = double1;
    }

    // Having both a step def with double and float gives cucumber.runtime.AmbiguousStepDefinitionsException:
    // "I have 42.5 cucumbers in my belly" matches more than one step definition:
    // (Which is as expected :)

    // Using float instead of double works.
//    @Given("I have {float} cucumbers in my belly")
//    public void i_have_cucumbers_in_my_belly(float slices) {
//        floatingSlices = slices;
//    }

//    @Given("I have {float} cucumbers in my belly")
//    public void i_have_cucumbers_in_my_belly(float float1) {
//        floatingSlices = float1;
//    }

    // Obviously it doesn't generate a step with {word} in it, because how would it know which word is my variable
    // Replacing with {word} AND adding an argument works
    // (if argument not added, throws "cucumber.runtime.CucumberException: Arity mismatch:" - as expected)
    // - IntelliJ gives an error on {word} saying "Number expected"
    @When("I test {word}")
    public void i_test_expressions(String word) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    // - IntelliJ gives an error on {string} saying "Number expected"
    @Then("my test should {string}")
    public void my_test_should_very_surely_pass(String multipleWords) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    // By default generates step with {int}
    // throws java.lang.NumberFormatException: For input string: "99999999999999999999"
//    @Given("I have a really large number of {int} pickles")
//    public void i_have_a_really_large_number_of_pickles(Integer int1) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }

    @Given("I have a really large number of {bigint} pickles")
    public void i_have_a_really_large_number_of_pickles(BigInteger int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    // By default generates step with {double}
    // This does not throw any error though
    @Given("I have a really large number of {double} pickle slices")
    public void i_have_a_really_large_number_of_pickle_slices(Double double1) {
        doubleSlices = double1;
    }

    // Replacing {double} with {bigdec} throws an exception:
    // io.cucumber.cucumberexpressions.UndefinedParameterTypeException: Undefined parameter type {bigdec}
    @Given("I have a really large number of {bigdecimal} pickle slices")
    public void i_have_a_really_large_number_of_pickle_slices(BigDecimal bigDecimal) {
        bigDecimalSlices = bigDecimal;
    }

    @Then("I can use bigint and bigdec")
    public void i_can_use_bigint_and_bigdec() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("I have {byte} cucumbers in my belly/stomach")
    public void i_have_byte_cucumbers_in_my_belly(Byte byte1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
