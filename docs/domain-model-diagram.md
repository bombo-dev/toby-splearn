```mermaid
erDiagram
    MEMBER ||--|o INSTRUCTOR : _
    INSTRUCTOR ||--o{ LECTURE : _

    MEMBER ||--o{ ENROLLMENT : _
    
    LECTURE ||--o{ SECTION : _
    LECTURE ||--o{ LESSON : _
    
    ENROLLMENT ||--|o LECTURE_PROGRESS : _

    SECTION ||--o{ LESSON : _

    ENROLLMENT }o--|| LECTURE : _
```
