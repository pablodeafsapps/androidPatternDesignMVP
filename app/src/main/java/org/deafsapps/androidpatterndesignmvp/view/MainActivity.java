package org.deafsapps.androidpatterndesignmvp.view;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.deafsapps.androidpatterndesignmvp.MainContract;
import org.deafsapps.androidpatterndesignmvp.R;
import org.deafsapps.androidpatterndesignmvp.presenter.MainActivityPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * This class represents the main view of the application, and the entry point to it, as declared
 * in the {@link Manifest}.
 *
 * @author psor1i
 * @since 1.0
 */
public class MainActivity extends AppCompatActivity implements MainContract.View {

	private static final String TAG = MainActivity.class.getSimpleName();

	@BindView(R.id.tv_display_info)
	TextView tvDisplayInfo;

	// Referernce to an interface, so that polymorphism is used later
	private MainContract.Presenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		this.presenter = new MainActivityPresenter(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		presenter.viewAboutToGetClosed();
	}

	@OnClick({R.id.btn_disp_info_main_activity, R.id.btn_start_act_main_activity})
	public void selectMainActivityAction(Button button) {
		Log.d(MainActivity.TAG, "In-selectMainActivityAction");

		if (button.getId() == R.id.btn_disp_info_main_activity) {
			presenter.displayInfoClicked();
		} else if (button.getId() == R.id.btn_start_act_main_activity) {
			presenter.startActivityClicked();
		}
	}

	@Override
	public void showInfo(String info) {
		tvDisplayInfo.setText(info);
	}

	@Override
	public void showErrorMessage(String error) {
		Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void startSecondActivity(@Nullable Bundle data) {
		Intent intent = new Intent(this, SecondActivity.class);
		if (data != null) {
			intent.putExtras(data);
		}
		startActivity(intent);
	}
}
