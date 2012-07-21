package sh.calaba.instrumentationbackend.actions.text;

import android.view.View;
import android.widget.EditText;
import sh.calaba.instrumentationbackend.InstrumentationBackend;
import sh.calaba.instrumentationbackend.Result;
import sh.calaba.instrumentationbackend.TestHelpers;
import sh.calaba.instrumentationbackend.actions.Action;

public class ClearTextById implements Action {

	@Override
	public Result execute(String... args) {
        String contentDescription = args[0];
        final View view = TestHelpers.getViewById(args[1]);
        if(view == null) {
            return new Result(false, "No view found with id: '" + contentDescription + "'");
        } else if (!(view instanceof EditText)) {
            return new Result(false, "Expected EditText found: '" + view.getClass() + "'");
        } else {
            InstrumentationBackend.solo.clearEditText((EditText)view);
            return Result.successResult();
        }
	}

	@Override
	public String key() {
		return "clear_id_field";
	}

}
