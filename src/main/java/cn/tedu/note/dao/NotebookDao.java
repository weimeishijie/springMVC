package cn.tedu.note.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by mj on 2017/11/16.
 */
public interface NotebookDao {

    List<Map<String, Object>> findNotebookByUserId(String userId);

}
