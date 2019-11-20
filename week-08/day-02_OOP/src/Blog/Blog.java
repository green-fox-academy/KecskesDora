package Blog;

import java.util.ArrayList;

public class Blog {
    ArrayList<BlogPost> listOfBlogs;

    public Blog() {
        listOfBlogs = new ArrayList<>();
    }

    public void add(BlogPost blogPost) {
        listOfBlogs.add(blogPost);
    }

    public void delete(int index) {
        if (index < listOfBlogs.size()) {
            listOfBlogs.remove(index);
        } else {
            System.out.println("The blog is smaller, type in a lower number");
        }
    }

    public void update(int index, BlogPost blogPost) {
        delete(index);
        listOfBlogs.add(index, blogPost);
    }

    public void update2(int index, BlogPost blogPost) {

        listOfBlogs.set(index, blogPost);
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < listOfBlogs.size(); i++) {
            result += listOfBlogs.get(i) + " ";
        }
        return result;
    }
}
