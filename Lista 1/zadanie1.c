#include <stdio.h>
#include <stdlib.h>
#include <time.h>


struct Node {
    int data;
    struct Node * next;
};

int comp1;
int comp2;

// Inserts an element at the begging of the list
void push(struct Node** head, int new_data) 
{ 
    struct Node* new_node = malloc(sizeof(struct Node)); 
   
    new_node->data = new_data; 
    new_node->next = (*head); 

    (*head) = new_node; 
}

// Inserts an element at the end of the list
void insert(struct Node** head, int new_data){

	struct Node* new_node = malloc(sizeof(struct Node));
	struct Node* temp = *head;

	new_node->data = new_data;
	new_node->next = NULL;

	// If head is null, create new head
	if(*head == NULL) {
		*head = new_node;
		return;
	}

	// Looks for the last element
	while (temp->next != NULL) { 
    	comp1++;
        temp = temp->next; 
    }

    temp->next = new_node;
}

void isEmpty(struct Node* head){

	if(head == NULL){
		printf("EMPTY LIST\n");
	}
}

// Deletes the node with data = key
void deleteNode(struct Node **head, int key) 
{ 
    struct Node* temp = *head, *prev; 
   
   //Head need's to be deleted
    if (temp != NULL && temp->data == key){ 				  
        *head = temp->next;   	
        free(temp);               
        return; 
    } 
  
  	//Finds the element that should be deleted
    while (temp != NULL && temp->data != key) { 
        prev = temp; 
        temp = temp->next; 
    } 
   
    if (temp == NULL){
    	printf("Element doesn't exist.\n");
    	return;
    } 
  
    prev->next = temp->next; 
  
    free(temp);
} 
  
//Prints the list  
void printList(struct Node *head){

	struct Node* node = head;

	printf("List elements: ");

    while (node != NULL) { 
        printf("%d ", node->data);
        node = node->next; 
    } 

    printf("\n"); 
}

//Finds element in the list and if it exists puts it in the head
void findMTF(struct Node **head, int key){

	struct Node* temp = *head;
	struct Node* headSave = *head;
	struct Node* prev = NULL;
	
	comp1++;
	comp1++;
	if (temp != NULL && temp->data == key){

        return; 
    }

	while (temp != NULL && temp->data != key){ 
    	comp1++;
    	comp1++;

    	prev = temp;
        temp = temp->next; 
    }

    comp1++;
    if (temp == NULL){
    	return;
    }

    prev->next = temp->next;

    *head = temp;
    temp->next = headSave;
    return;
}

//Finds element in the list and switches it with the preceding one
void findTRANS(struct Node **head, int key){

	struct Node* temp = *head;
	struct Node* beforePrev = NULL;
	struct Node* prev = *head;
	
	//You can't transfer first element or list is too short to make a transfer
	comp2++;
	comp2++;
	if(temp->data == key || temp->next == NULL){
		return;
	}

	//If the key is on second position (it would be skipped in the loop), use MTF and calculate the counter properly
	if(temp->next != NULL && (temp->next)->data == key){

		findMTF(head, key);
		comp1--;
		comp2++;
		
		return;
	}


	while (temp != NULL && temp->data != key){ 	
    	comp2++;
    	comp2++;

    	beforePrev = prev;
    	prev = beforePrev->next;
        temp = prev->next;
    }

    // If element wasn't found in the list
    comp2++;
    if(temp == NULL){
    	return;
    }

    prev->next = temp->next;
	temp->next = prev;
	beforePrev->next=temp;
}  


int main(int argc, char const *argv[])
{

	srand ( time(NULL) );

	struct Node* head = NULL;
	int numbersArray[100]; 

	for(int i = 1; i <= 100; i++){
		numbersArray[i-1] = i;
	}


	for(int i = 0; i < 100; i++){

		int j = i + rand() / (RAND_MAX / (100 - i) + 1);
		int temp = numbersArray[j];
		numbersArray[j] = numbersArray[i];
		numbersArray[i] = temp;
		insert(&head, numbersArray[i]);
	}

	printf("\n");	
	printList(head);
	printf("\n");

	for (int i = 100; i > 0; i--){
		for (int j = 1; j <=100; j++){	
			findMTF(&head,j);
		}
		deleteNode(&head, i);
		comp1++;	
	}

	printf("MTF comparations: %d\n",comp1);

	// Create new list for trans comparations
	for(int i = 0; i < 100; i++){
		push(&head, numbersArray[i]);
	}

	for (int i = 100; i > 0; i--){
		for (int j = 1; j <=100; j++){	
			findTRANS(&head,j);
		}
		deleteNode(&head, i);
		comp2++;	
	}

	
	printf("TRANS comparations: %d\n",comp2);

	return 0;
}