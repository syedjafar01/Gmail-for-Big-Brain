package com.razorthink.trackmymail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class AfterAuthenticationServlet
 */
public class AfterAuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfterAuthenticationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		/*String code=request.getParameter("code");
		StringBuffer jb=new StringBuffer();
		String line=null;
		//String aToken=request.getParameter("access_token");
		
		System.out.println(code);
		GmailDataPojo pojo=new GmailDataPojo();
		System.out.println("Token: "+pojo.getAccessToken());
		if(pojo.getAccessToken()==null)
		{
			String url="https://www.googleapis.com/oauth2/v4/token?code="+code+"client_id=929742997040-rbs5bbha3dqcp52klqtd8h1257q86i06.apps.googleusercontent.com&client_secret=nXUC96FXTMkRj0h-Al3spS0-&grant_type=authorization_code&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2FTrackMyMail%2FafterGettingAuthCode.do";
			response.sendRedirect(url);
					
		}*/
		
		
		
		System.out.println("entering doGet");
        try {
            // get code
            String code = request.getParameter("code");
            // format parameters to post
            String urlParameters = "code="+code+"&approval_prompt=force&access_type=offline&client_id=929742997040-rbs5bbha3dqcp52klqtd8h1257q86i06.apps.googleusercontent.com"+"&client_secret=nXUC96FXTMkRj0h-Al3spS0-"+"&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2FTrackMyMail%2FafterGettingAuthCode.do"+"&grant_type=authorization_code";
            
            //post parameters
            URL url = new URL("https://www.googleapis.com/oauth2/v4/token");
            URLConnection urlConn = url.openConnection();
            urlConn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(urlConn.getOutputStream());
            writer.write(urlParameters);
            writer.flush();
            
            //get output in outputString 
            String line, outputString = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            while ((line = reader.readLine()) != null) {
                outputString += line;
            }
            System.out.println(outputString);
            Gson gson=new GsonBuilder().create();
            
            TokenPojo pojo=gson.fromJson(outputString, TokenPojo.class);
            System.out.println("Access Token: "+pojo.getAccess_token());
            System.out.println("Refresh Token: "+pojo.getRefresh_token());
            
            request.setAttribute("accessToken", pojo.getAccess_token());
           // RequestDispatcher rd=request.getRequestDispatcher("gotToken.do");		
           // rd.forward(request, response);
            //String accessToken=pojo.getAccess_token();
            //response.sendRedirect("https://www.googleapis.com/oauth2/v1/userinfo?access_token="+accessToken);
            		
            		
            		
            		
       
            
            //get Access Token 
            //JsonObject json = (JsonObject)new JsonParser().parse(outputString);
            //String access_token_string = json.get("access_token").getAsString();
            //String[] arr1=access_token_string.split(":");
            //String a1=arr1[1];
            //System.out.println(a1);

            //get User Info 
           /* url = new URL(
                    "https://www.googleapis.com/oauth2/v1/userinfo?access_token="
                            + access_token);
            urlConn = url.openConnection();
            outputString = "";
            reader = new BufferedReader(new InputStreamReader(
                    urlConn.getInputStream()));
            while ((line = reader.readLine()) != null) {
                outputString += line;
            }
            System.out.println(outputString);
            
            // Convert JSON response into Pojo class
            GooglePojo data = new Gson().fromJson(outputString, GooglePojo.class);
            System.out.println(data);
            writer.close();
            reader.close();*/
            
        } catch (MalformedURLException e) {
            System.out.println( e);
        } catch (ProtocolException e) {
            System.out.println( e);
        } catch (IOException e) {
            System.out.println( e);
        }
        System.out.println("leaving doGet");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
