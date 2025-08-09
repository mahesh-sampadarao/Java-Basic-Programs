public class NestedClassesPracticeWithExamples {

    public void run(){
        class Local{
            public void run(){
                System.out.println("Local Class Called");
            }
        }

        Local local=new Local();
        local.run();
    }

    public static class staticNestedClass{
        public void run(){
            System.out.println("Static Nested Class Called");
        }
    }

    public static class instanceNestedClass{
        public void run(){
            System.out.println("Instance/Non-Static Nested Class Called");
        }
    }

    public static void main(String[] args) {
        //staticNestedClass
        NestedClassesPracticeWithExamples.staticNestedClass nestedClass=new NestedClassesPracticeWithExamples.staticNestedClass();
        nestedClass.run();

        //instanceNestedClass
        NestedClassesPracticeWithExamples.instanceNestedClass instanceClass=new NestedClassesPracticeWithExamples.instanceNestedClass();
        instanceClass.run();

        //localInnerClass
        NestedClassesPracticeWithExamples innerClass=new NestedClassesPracticeWithExamples();
        innerClass.run();

        //AnonymousClass example refer to Comparator Implementation in CustomSortigUsingComparatorInterface

    }

}
