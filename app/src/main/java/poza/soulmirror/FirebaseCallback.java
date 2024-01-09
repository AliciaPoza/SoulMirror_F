package poza.soulmirror;

public interface FirebaseCallback<T> {
    void onSuccess(T result);
    void onFailure(Exception e);
}
