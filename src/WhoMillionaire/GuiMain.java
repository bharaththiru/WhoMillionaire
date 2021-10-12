/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhoMillionaire;

/**
 *
 * @author bhara
 */
public class GuiMain 
{
    public static void main(String[] args) 
    {
        GuiView view = new GuiView();
        GuiModel model = new GuiModel();
        GuiController controller = new GuiController(view, model);
    }
}
