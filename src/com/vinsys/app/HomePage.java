package com.vinsys.app;

import java.io.Serializable;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.JavascriptPackageResource;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.markup.html.resources.JavascriptResourceReference;
import org.apache.wicket.model.Model;

public class HomePage extends WebPage{
	
	/*public HomePage(PageParameters parameters){
		super(parameters);
	}*/
	
	
	/*public HomePage(){
		Label hello = new Label("hello_label","Hello Label");
		add(hello);
	}*/
	
	/*public HomePage(){
		Model<Serializable> lebel = new Model(){
			
			@Override
			public Serializable getObject() {
				// TODO Auto-generated method stub
				return "Greeting";
			}
		};
		Label hello = new Label("hello_label",lebel);
		add(hello);
	}*/
	
	public HomePage(){
		//CompressedResourceReference
		JavascriptResourceReference ref=  new JavascriptResourceReference(HomePage.class,"default.js");
		FeedbackPanel feedback = new FeedbackPanel("errormsg");
		
		Form loginForm = new Form("loginForm");
		Model userModel = new Model();
		TextField tx = new TextField("userName",userModel);
		
		add(feedback);
		loginForm.add(tx);
		tx.add(new UserValidator());
			Button button = new Button("submit"){
				
				@Override
				public void onSubmit() {
					System.out.println("User Nmae----------"+userModel.getObject());
					setResponsePage(Success.class);
				}
			};
			
		loginForm.add(button);
		Model<Serializable> lebel = new Model(){
			
			@Override
			public Serializable getObject() {
				// TODO Auto-generated method stub
				return "Greeting";
			}
		};
		
		Link link = new Link("linkid"){
			
			@Override
			public void onClick() {
				setResponsePage(Success.class);
				
			}
		};
		Label hello = new Label("hello_label",lebel);
		add(hello);
		add(link);
		add(loginForm);
		add(JavascriptPackageResource.getHeaderContribution(ref));
	}


}
