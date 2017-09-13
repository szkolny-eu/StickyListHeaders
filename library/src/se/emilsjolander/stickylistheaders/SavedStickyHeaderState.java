package se.emilsjolander.stickylistheaders;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

public class SavedStickyHeaderState extends View.BaseSavedState {

    private final Parcelable mListState;

    public SavedStickyHeaderState(Parcelable viewState, Parcelable listState) {
        super(viewState);
        mListState = listState;
    }

    private SavedStickyHeaderState(Parcel in, ClassLoader classLoader) {
        super(in);
        mListState = in.readParcelable(classLoader != null ? classLoader : null);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(mListState, flags);
    }

    public Parcelable getListState() {
        return mListState;
    }

    public static final Creator<SavedStickyHeaderState> CREATOR = new CompatCreator();

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private static class CompatCreator implements
            Creator<SavedStickyHeaderState>,
            ClassLoaderCreator<SavedStickyHeaderState> {

        @Override
        public SavedStickyHeaderState createFromParcel(Parcel source, ClassLoader loader) {
            return new SavedStickyHeaderState(source, loader);
        }

        @Override
        public SavedStickyHeaderState createFromParcel(Parcel in) {
            return new SavedStickyHeaderState(in, null);
        }

        @Override
        public SavedStickyHeaderState[] newArray(int size) {
            return new SavedStickyHeaderState[size];
        }
    }
}
