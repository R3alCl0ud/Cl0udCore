package cl0udcore.util.JSON;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class JSONUtils
{

	public static String readFile(File file) throws IOException
	{
		return readFile(file, "ASCII");
	}

	public static String readFile(File file, String encoding) throws IOException
	{
		FileInputStream fin = new FileInputStream(file);
		InputStreamReader inr = new InputStreamReader(fin, encoding);
		BufferedReader br = new BufferedReader(inr);
		StringBuffer sb = new StringBuffer();
		for (;;)
		{
			String line = br.readLine();
			if (line == null)
			{
				break;
			}
			sb.append(line);
			sb.append("\n");
		}
		br.close();
		inr.close();
		fin.close();

		return sb.toString();
	}

	public static byte[] readAll(InputStream is) throws IOException
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		for (;;)
		{
			int len = is.read(buf);
			if (len < 0)
			{
				break;
			}
			baos.write(buf, 0, len);
		}
		is.close();

		byte[] bytes = baos.toByteArray();

		return bytes;
	}

	public static void updateJson(File MusicDir, String RecordName) throws IOException, ParseException
	{

		File soundJson = new File(MusicDir, "sounds.json");
		String json = readFile(soundJson);
		JSONParser jp = new JSONParser();

		JSONObject root = (JSONObject) jp.parse(json);
		root.put(RecordName, "");

	}
}
