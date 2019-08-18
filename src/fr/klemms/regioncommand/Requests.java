package fr.klemms.regioncommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.bukkit.Bukkit;

public class Requests {

	public static int getVersion(String plugin) {
		URLConnection urlC = null;
		try {
			urlC = new URL("http://klemms.ovh/minecraftdev/" + plugin + "/?bukkitversion=" + Bukkit.getBukkitVersion()).openConnection();
			urlC.setConnectTimeout(5000);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try(BufferedReader in1 = new BufferedReader(new InputStreamReader(urlC.getInputStream()))) {
			return Integer.valueOf(in1.readLine());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static String getVersionURL(String plugin) {
		URLConnection urlC = null;
		try {
			urlC = new URL("http://klemms.ovh/minecraftdev/" + plugin + "/?bukkitversion=" + Bukkit.getBukkitVersion()).openConnection();
			urlC.setConnectTimeout(5000);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try(BufferedReader in1 = new BufferedReader(new InputStreamReader(urlC.getInputStream()))) {
			in1.readLine();
			return in1.readLine();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
