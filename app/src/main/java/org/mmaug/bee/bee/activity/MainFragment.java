package org.mmaug.bee.bee.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.LoginButton;
import org.mmaug.bee.bee.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private static final String ARG_PARAM1 = "param1";
private static final String ARG_PARAM2 = "param2";

// TODO: Rename and change types of parameters
private String mParam1;
private String mParam2;

private OnFragmentInteractionListener mListener;
private UiLifecycleHelper uiHelper;

/**
 * Use this factory method to create a new instance of
 * this fragment using the provided parameters.
 *
 * @param param1 Parameter 1.
 * @param param2 Parameter 2.
 * @return A new instance of fragment MainFragment.
 */
// TODO: Rename and change types and number of parameters
public static MainFragment newInstance(String param1, String param2) {
  MainFragment fragment = new MainFragment();
  Bundle args = new Bundle();
  args.putString(ARG_PARAM1, param1);
  args.putString(ARG_PARAM2, param2);
  fragment.setArguments(args);
  return fragment;
}

public MainFragment() {
  // Required empty public constructor
}

@Override
public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  uiHelper = new UiLifecycleHelper(getActivity(), callback);
  uiHelper.onCreate(savedInstanceState);
  if (getArguments() != null) {
    mParam1 = getArguments().getString(ARG_PARAM1);
    mParam2 = getArguments().getString(ARG_PARAM2);
  }
}

private void onSessionStateChange(Session session, SessionState state, Exception exception) {
  if (state.isOpened()) {
    Log.i("Login", "Logged in...");
  } else if (state.isClosed()) {
    Log.i("Not Login", "Logged out...");
  }
}

private Session.StatusCallback callback = new Session.StatusCallback() {
  @Override
  public void call(Session session, SessionState state, Exception exception) {
    onSessionStateChange(session, state, exception);
  }
};

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
  // Inflate the layout for this fragment
  View view =  inflater.inflate(R.layout.fragment_main, container, false);
  LoginButton authButton = (LoginButton) view.findViewById(R.id.authButton);
  authButton.setFragment(this);
  return
}

// TODO: Rename method, update argument and hook method into UI event
public void onButtonPressed(Uri uri) {
  if (mListener != null) {
    mListener.onFragmentInteraction(uri);
  }
}

@Override
public void onAttach(Activity activity) {
  super.onAttach(activity);
  try {
    mListener = (OnFragmentInteractionListener) activity;
  } catch (ClassCastException e) {
    throw new ClassCastException(activity.toString()
                                     + " must implement OnFragmentInteractionListener");
  }
}

@Override
public void onDetach() {
  super.onDetach();
  mListener = null;
}

/**
 * This interface must be implemented by activities that contain this
 * fragment to allow an interaction in this fragment to be communicated
 * to the activity and potentially other fragments contained in that
 * activity.
 * <p>
 * See the Android Training lesson <a href=
 * "http://developer.android.com/training/basics/fragments/communicating.html"
 * >Communicating with Other Fragments</a> for more information.
 */
public interface OnFragmentInteractionListener {
  // TODO: Update argument type and name
  public void onFragmentInteraction(Uri uri);
}

@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
  super.onActivityResult(requestCode, resultCode, data);
  uiHelper.onActivityResult(requestCode, resultCode, data);
}

@Override
public void onResume() {
  super.onResume();
  uiHelper.onResume();
}

@Override
public void onPause() {
  super.onPause();
  uiHelper.onPause();
}

@Override
public void onDestroy() {
  super.onDestroy();
  uiHelper.onDestroy();
}

@Override
public void onSaveInstanceState(Bundle outState) {
  super.onSaveInstanceState(outState);
  uiHelper.onSaveInstanceState(outState);
}
}
