package Blog;

public class BlogMain {
    public static void main(String[] args) {
        Blog blog = new Blog();

        BlogPost blogPost1 = new BlogPost("Jani");
        BlogPost blogPost2 = new BlogPost("Zoli");
        BlogPost blogPost3 = new BlogPost("Józsi");
        BlogPost blogPost4 = new BlogPost("Béla");
        BlogPost blogPost5 = new BlogPost("Karesz");

        blog.add(blogPost1);
        blog.add(blogPost2);
        blog.add(blogPost3);
        System.out.println(blog);
        blog.update(2, blogPost4);
        System.out.println(blog);
        blog.update2(1, blogPost5);
        System.out.println(blog);
    }
}

//Reuse your BlogPost class
//Create a Blog class which can
//  store a list of BlogPosts
//  add BlogPosts to the list
//  delete(int) one item at given index
//  update(int, BlogPost) one item at the given index and update it with another BlogPost