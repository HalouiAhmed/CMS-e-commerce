import { NgModule } from "@angular/core";
import { MatTabsModule } from '@angular/material/tabs';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatChipsModule } from '@angular/material/chips';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatDialogModule } from '@angular/material/dialog';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatRadioModule } from '@angular/material/radio';
import { MatDividerModule } from '@angular/material/divider';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatCardModule } from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatExpansionModule} from '@angular/material/expansion';
@NgModule({
    imports: [
        MatTabsModule,
        MatFormFieldModule,
        MatInputModule,
        MatIconModule,
        MatSnackBarModule,
        MatChipsModule,
        MatButtonModule,
        MatSelectModule,
        MatCheckboxModule,
        MatSidenavModule,
        MatToolbarModule,
        MatDialogModule,
        MatProgressSpinnerModule,
        MatRadioModule,
        MatDividerModule,
        MatAutocompleteModule,
        MatCardModule,
        MatGridListModule,
        MatExpansionModule
    ],
    exports: [
        MatTabsModule,
        MatFormFieldModule,
        MatInputModule,
        MatIconModule,
        MatSnackBarModule,
        MatChipsModule,
        MatButtonModule,
        MatSelectModule,
        MatCheckboxModule,
        MatSidenavModule,
        MatToolbarModule,
        MatDialogModule,
        MatProgressSpinnerModule,
        MatRadioModule,
        MatDividerModule,
        MatAutocompleteModule,
        MatCardModule,
        MatGridListModule,
        MatExpansionModule
    ]
})
export class MaterialModule { }