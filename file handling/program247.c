#include<stdio.h>
#include<stdlib.h>
#include<fcntl.h>
#include<unistd.h>
#include<string.h>

#define BUFFER_SIZE 1024

int main()
{
    char Fname[20] = {"\0"};
    int fd = 0, iRet = 0, iCnt = 0, iCapCount = 0;
    char Buffer[BUFFER_SIZE] = {'\0'};

    printf("Enter the file name that you want to open : \n");
    scanf("%s",Fname);

    fd = open(Fname, O_RDONLY);         

    if(fd == -1)
    {
        printf("Unable to open file.");
    
    }
    else
    {
        printf("file is successfully opened\n");

        while((iRet = read(fd,Buffer,BUFFER_SIZE)) != 0)
        {
            for(iCnt = 0; iCnt < iRet; iCnt++)
            {
                if((Buffer[iCnt] >= 'A') && (Buffer[iCnt] <= 'Z')) 
                {
                    iCapCount++;
                }
                //printf("%c\t",Buffer[iCnt]);
            }
           
            memset(Buffer,'\0',BUFFER_SIZE);
           
        }
        printf("\nNumber of capital charter are : %d \n",iCapCount);

        close(fd);   
    }


    return 0;
}