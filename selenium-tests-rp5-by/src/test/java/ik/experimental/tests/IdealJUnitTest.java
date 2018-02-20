package ik.experimental.tests;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // UI tests
public class IdealJUnitTest {

	@BeforeClass
	public static void setUp() {
		System.out.println("-Before class");
	}

	@AfterClass
	public static void tearDown() {
		System.out.println("-After class");
	}

	@Before
	public void beforeMethod() {
		System.out.println("--Before method");
	}

	@After
	public void afterMethod() {
		System.out.println("--After method");
	}

	@Rule
	public TestName name = new TestName();

	@Rule
	public final TemporaryFolder tempFolder = new TemporaryFolder();
	
	@Test
	public void test01() {
		System.out.println("\n" + name.getMethodName() + "\n" + tempFolder.getRoot().getPath());
	}

	@Test
	public void test02() {
		Assert.assertThat("aa O_K bb", not(containsString("OK")));
	}

	@Test
	public void test03() {
		assumeFalse("assumption severy violated", false);
		assertThat("some", equalTo("some"));
	}

	@Rule
	public final TestRule globalTimeout = Timeout.seconds(1);

	@Test
	public void testInfiniteLoop() {
		@SuppressWarnings("unused")
		int i = 0;
		while (true) {
			i += 1;
		}
	}

	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	@Test
	public void throwsNullPointerExceptionWithMessage() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("happened?");
		thrown.expectMessage(startsWith("What"));
		throw new NullPointerException("What happened?");
	}

	@Test
	public void testFailed() {
		assertThat("some", anyOf(equalTo("some"), containsString("so")));
		fail();
	}

	@Test
	public void testSucceeded() {
	}

}
