package firstproject2.mcs.com.roomdataexample;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class wordViewModel extends AndroidViewModel {

    private wordRepository mRepository;

    private LiveData<List<word>> mAllWords;

    public wordViewModel (Application application) {
        super(application);
        mRepository = new wordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    LiveData<List<word>> getAllWords() { return mAllWords; }

    public void insert(word word) { mRepository.insert(word); }
}