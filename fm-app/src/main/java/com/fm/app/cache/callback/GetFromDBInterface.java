package com.fm.app.cache.callback;

import java.util.List;

public interface GetFromDBInterface {

	public interface getObj<T> {
		public T getObj(Object... args);
	}

	public interface getList<T> {
		public List<T> getList(Object... args);
	}

}
