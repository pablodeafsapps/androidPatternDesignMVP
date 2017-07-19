package org.deafsapps.androidpatterndesignmvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.deafsapps.androidpatterndesignmvp.R;
import org.deafsapps.androidpatterndesignmvp.SecondContract;
import org.deafsapps.androidpatterndesignmvp.presenter.SecondActivityPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * This class represents another view of the application, which directly links relates to
 * {@link MainActivity}.
 *
 * @author psor1i
 * @since 1.0
 */
public class SecondActivity extends AppCompatActivity implements SecondContract.View {

	private static final String TAG = SecondActivity.class.getSimpleName();

	@BindView(R.id.et_info_to_return)
	TextView etReturnInfo;

	// Referernce to an interface, so that polymorphism is used later
	private SecondContract.Presenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		ButterKnife.bind(this);

		this.presenter = new SecondActivityPresenter(this);
	}

	@OnClick(R.id.btn_ok)
	public void selectOkAction(Button button) {
		Log.d(SecondActivity.TAG, "In-selectOkAction");

		presenter.okClicked(etReturnInfo.getText().toString());
	}

	@Override
	public void showErrorMessage(String error) {
		Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void showInfoStoredMessage(String info) {
		Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void clearEditText() {
		this.etReturnInfo.setText("");
	}
}
