package commands;

import org.junit.runner.RunWith;

@RunWith(TestAccordionRunner.class)
public class LooseAssertEqualsCommandTest {

    public Foo getFoo() {
        return new Foo();
    }

    public class Foo {
        public Bar getBar() {
            return new Bar();
        }
    }

    public class Bar {
        public String getFoobar() {
            return "Some Equal Thing";
        }
    }

}
