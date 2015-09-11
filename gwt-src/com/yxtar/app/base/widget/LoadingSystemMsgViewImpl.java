/**
 * 
 */
package com.yxtar.app.base.widget;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author jackshi
 * 
 */
public class LoadingSystemMsgViewImpl implements SystemMsgView {
	private VerticalPanel rootPanel = new VerticalPanel();
	private FixPopupPanel dialogBox = new FixPopupPanel(false,false);
	private FixPopupPanel glassBox = new FixPopupPanel(true,false);
	private Image loadingImage = new Image("./image/loading.gif");
	private String cssMain = "max-width:796px; min-height:45px;outline:none;";
	private int rootheight = 200;
	private int height = (Window.getClientHeight() - rootheight) / 2;

	public LoadingSystemMsgViewImpl() {
		cssMain = cssMain + "margin:0px auto;margin-top:" + height + "px;";
		rootPanel.getElement().setAttribute("style", cssMain);
		rootPanel.setHorizontalAlignment(HasAlignment.ALIGN_CENTER);
		rootPanel.setVerticalAlignment(HasAlignment.ALIGN_MIDDLE);
		rootPanel.add(loadingImage);
		rootPanel.setSize("200px", rootheight + "px");
		loadingImage.setWidth("100px");
		loadingImage.setHeight("100px");
		glassBox.add(rootPanel);
	}

	@Override
	public void showMsg(SystemMsgType systemMsgType, String msg) {

	}

	public void setLoadingImg(String path){
		if (path!=null&&!path.equals("")) {
			loadingImage.setUrl(path);
		}else {
			loadingImage.setUrl("./image/loading.gif");
		}
	}
	@Override
	public void show() {
		dialogBox.shows();
		glassBox.shows();

	}

	@Override
	public void hide() {
		glassBox.hides();
		dialogBox.hides();
	}


	@Override
	public void setListener(Listener l) {
		// TODO Auto-generated method stub
		
	}

}
