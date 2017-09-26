/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liferay.blade.test.deprecatedmethods;

import com.liferay.blade.api.Migration;
import com.liferay.blade.api.Problem;
import com.liferay.blade.util.NullProgressMonitor;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

public class DeprecatedMethodsTest {

	@Test
	public void findProblems() throws Exception {
		ServiceReference<Migration> sr = context.getServiceReference(Migration.class);

		Migration m = context.getService(sr);

		List<Problem> problems = 
			m.findProblems(new File("projects/deprecated-methods-test"), 
				new NullProgressMonitor());

		assertEquals(125, problems.size());
	}

	private final BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();

}