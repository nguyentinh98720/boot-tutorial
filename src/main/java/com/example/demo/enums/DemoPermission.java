/**
 * 
 */
package com.example.demo.enums;

/**
 * @since Apr 1, 2023
 *
 */
public enum DemoPermission {

    CAR(null, "Car"),
    CAR_VIEW_LIST(CAR, "View list car records"),
    CAR_VIEW_DETAIL(CAR, "View car detail"),
    CAR_MODIFY(CAR, "Modify the car information"),
    CAR_REMOVE(CAR, "Remove/Delete the car record"),
    CAR_CREATE(CAR, "Create/Add new car record")

    // ...

    ;

    private final DemoPermission parent;
    private final String meaning;

    DemoPermission(DemoPermission parent, String meaning) {
        this.parent = parent;
        this.meaning = meaning;
    }

    public DemoPermission getParent() {
        return parent;
    }

    public String getMeaning() {
        return meaning;
    }
}
