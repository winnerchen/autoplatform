package yiheng.chen.cms.dao.model;

import java.util.List;


public class UserVO extends User {

	private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
