package yiheng.chen.common.util;



public class Paginator {

	private long total = 0l;			// total result count
	private int page = 1;				// current page number
	private long totalPage = 1;			// total page count
	private int rows = 10;				// result number per page
	private int step = 5;				// max displayed page number
	// name of paging parameter, used to support multiple paging functions in a single page
	private String param = "page";
	private String url = "";			// project path
	private String query = "";			// all parameters of current page
	
	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
		this.initTotalPage();
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		// set max result number for a single page
		if (rows > 10000) {
			rows = 10000;
		}
		this.rows = rows;
		this.initTotalPage();
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
	/**
	 * initialize paging info
	 */
	public void initTotalPage() {
		totalPage = (total % rows) == 0 ? (total / rows) : ((total / rows) + 1);
		if (page > totalPage) {
			page = (int) totalPage;
		}
		if (page < 1) {
			page = 1;
		}
	}

	/**
	 * generate simple paging content
	 * @return
	 */
	public String getHtml() {
		// get current url and other parameters from request
		//String contextPath = request.getContextPath();
		//String requestURI = request.getRequestURI();
		//String url = contextPath + requestURI;
		//String url = request.getRequestURI();
		//String query = request.getQueryString();
		if (query != null) {
			String params = "";
			String[] querys = query.split("&");
			for (int i = 0; i < querys.length; i++) {
				if (querys[i].startsWith(param))
					continue;
				if (params.equals(""))
					params += querys[i];
				else
					params += "&" + querys[i];
			}
			if (!params.equals(""))
				url += "?" + params;
		}
		// result html
		String pages = "";

		int pageCount = (int) Math.ceil((double) total / rows);// calculate total page count
		if (pageCount <= 1) {
			return pages;
		}
		if (page > pageCount) {
			page = pageCount;
		}
		if (page <= 0) {
			page = 1;
		}

		// display previous page
		if (page > 1) {
			if (url.contains("?")) {
				pages = pages.concat("<a class=\"prev\" href=\"" + url + "&" + param + "=" + (page - 1) + "\">Prev</a>\n");
			} else {
				pages = pages.concat("<a class=\"prev\" href=\"" + url + "?" + param + "=" + (page - 1) + "\">Next</a>\n");
			}
		} else {
			// pages =
			// pages.concat("<a class=\"prev\" href=\"javascript:;\" style=\"color:#ccc\">上一页</a>\n");
		}

		if (pageCount > step) {
			// display paging number
			int listBegin = (page - (int) Math.floor((double) step / 2));//
			if (listBegin < 1) {
				listBegin = 1;
			}
			// display the first page
			if (listBegin >= 2) {
				if (url.contains("?")) {
					pages = pages.concat("<a href=\"" + url + "&" + param + "=1\">1</a> ... \n");
				} else {
					pages = pages.concat("<a href=\"" + url + "?" + param + "=1\">1</a> ... \n");
				}
			}
			// when the right side of page number has undisplayed pages
			if (pageCount - page >= page - listBegin) {
				for (int i = listBegin; i < (listBegin + step); i++) {
					if (i != page) {
						if (url.contains("?")) {
							pages = pages.concat("<a href=\"" + url + "&" + param + "=" + i + "\">" + i + "</a>\n");
						} else {
							pages = pages.concat("<a href=\"" + url + "?" + param + "=" + i + "\">" + i + "</a>\n");
						}
					} else {
						pages = pages.concat("<span class=\"current\">" + i + "</span>\n");
					}
				}
				// display the last page
				if (listBegin + step <= pageCount) {
					if (url.contains("?")) {
						pages = pages.concat(" ... <a href=\"" + url + "&" + param + "=" + pageCount + "\">" + pageCount + "</a>\n");
					} else {
						pages = pages.concat(" ... <a href=\"" + url + "?" + param + "=" + pageCount + "\">" + pageCount + "</a>\n");
					}
				}
			} else { // dispalay the last few remaining pages
				for (int i = (pageCount - step) + 1; i <= pageCount; i++) {
					if (i != page) {
						if (url.contains("?")) {
							pages = pages.concat("<a href=\"" + url + "&" + param + "=" + i + "\">" + i + "</a>\n");
						} else {
							pages = pages.concat("<a href=\"" + url + "?" + param + "=" + i + "\">" + i + "</a>\n");
						}
					} else {
						pages = pages.concat("<span class=\"current\">" + i + "</span>\n");
					}
				}
			}
		} else { // when total pageNum is less than step
			for (int i = 1; i <= pageCount; i++) {
				if (i != page) {
					if (url.contains("?")) {
						pages = pages.concat("<a href=\"" + url + "&" + param + "=" + i + "\">" + i + "</a>\n");
					} else {
						pages = pages.concat("<a href=\"" + url + "?" + param + "=" + i + "\">" + i + "</a>\n");
					}
				} else {
					pages = pages.concat("<span class=\"current\">" + i + "</span>\n");
				}
			}
		}
		// display next page
		if (page < pageCount) {
			if (url.contains("?")) {
				pages = pages.concat("<a class=\"next\" href=\"" + url + "&" + param + "=" + (page + 1) + "\">Next</a>\n");
			} else {
				pages = pages.concat("<a class=\"next\" href=\"" + url + "?" + param + "=" + (page + 1) + "\">Next</a>\n");
			}
		} else {
			// pages =
			// pages.concat("<a class=\"next\" href=\"javascript:;\" style=\"color:#ccc\">next</a>\n");
		}
		return pages;
	}

}
