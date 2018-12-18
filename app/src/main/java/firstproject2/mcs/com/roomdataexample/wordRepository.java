package firstproject2.mcs.com.roomdataexample;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class wordRepository {

    private wordDAO mWordDao;
    private LiveData<List<word>> mAllWords;

    wordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    LiveData<List<word>> getAllWords() {
        return mAllWords;
    }

    public void insert (word word) {
        new insertAsyncTask(mWordDao).execute(word);
    }


    private static class insertAsyncTask extends AsyncTask<word, Void, Void> {

        private wordDAO mAsyncTaskDao;

        insertAsyncTask(wordDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }


    }
}


