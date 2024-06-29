package basics;

import java.util.Arrays;
import java.util.List;

class Polymorphism1 {
    interface Post {
        void postOn(SNS sns);
    }

    static class Text implements Post {
        @Override
        public void postOn(SNS sns) {
            if (sns instanceof Facebook) {
                System.out.println("facebook-text");
            }

            if (sns instanceof Twitter) {
                System.out.println("twitter-text");
            }
        }
    }

    static class Picture implements Post {
        @Override
        public void postOn(SNS sns) {
            if (sns instanceof Facebook) {
                System.out.println("facebook-picture");
            }

            if (sns instanceof Twitter) {
                System.out.println("twitter-picture");
            }
        }
    }

    interface SNS {
    }

    static class Facebook implements SNS {
    }

    static class Twitter implements SNS {
    }

    static class GooglePlus implements SNS {
    }

    public static void main(String[] args) {
        List<Post> posts = Arrays.asList(new Text(), new Picture());
        List<SNS> sns = Arrays.asList(new Facebook(), new Twitter(), new GooglePlus());

        posts.forEach(p -> sns.forEach(s -> p.postOn(s)));
    }
}