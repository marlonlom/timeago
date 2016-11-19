/*
 * Copyright (c) 2016, marlonlom
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.github.marlonlom.utilities.timeago;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * The Main activity for sample usage for {@link TimeAgo}.
 *
 * @author marlonlom
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onCreateViewLayout();
    }

    /**
     * On create view layout.
     */
    private void onCreateViewLayout() {
        Calendar calendar = Calendar.getInstance();
        final String timeAgo = TimeAgo.from(calendar.getTime().getTime());
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, -15);
        final String timeAgo2 = TimeAgo.from(calendar.getTime().getTime());
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -4);
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        final String timeAgo3 = sdf.format(calendar.getTime().getTime())
                .concat(", ").concat(TimeAgo.from(calendar.getTime().getTime()));
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -7);
        final String timeAgo4 = sdf.format(calendar.getTime().getTime())
                .concat(", ").concat(TimeAgo.from(calendar.getTime().getTime()));

        final String outputText = getResources().getString(R.string.ta_sample_detail,
                timeAgo, timeAgo2, timeAgo3, timeAgo4);
        final TextView mSampleText = (TextView) findViewById(R.id.textview_main_result);
        mSampleText.setText(Html.fromHtml(outputText));
    }
}
