/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmleditor;

import algoritmen.*;

/**
 * @author Rian De Rous
 *
 */
public class UndoRedo {

    private FixedSizeStack undo;
    private FixedSizeStack redo;
    
    public UndoRedo(int size){
        undo = new FixedSizeStack(size);
        redo = new FixedSizeStack(size);
    }

    public void addStep(Object element) {
            undo.push(element);
    }

    public Object redo() {
        undo.push(redo.top());
        return redo.pop();
    }

    /**
     *
     * @return
     */
    public Object undo() {
        redo.push(undo.top());
        return (undo.pop());
    }
    
    public boolean undoIsEmpty(){
        return undo.isEmpty();
    }
    
    public boolean redoIsEmpty(){
        return undo.isEmpty();
    }
    
    
 
    
   

}
