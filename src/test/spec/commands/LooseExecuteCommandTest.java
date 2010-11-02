package commands;

import org.junit.runner.RunWith;

@RunWith(TestAccordionRunner.class)
public class LooseExecuteCommandTest {

    public Foo getFoo() {
        return new Foo();
    }

    public class Foo {
        public Bar getBar() {
            return new Bar();
        }
    }

    public class Bar {
        public FooBar getFoobar() {
            return new FooBar();
        }
    }

    public class FooBar {

    }
}
