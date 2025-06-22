```mermaid
erDiagram
    MEMBER ||--|o INSTRUCTOR : _
    INSTRUCTOR ||--o{ LECTURE : _

    MEMBER ||--o{ ENROLLMENT : _
    
    LECTURE ||--o{ SECTION : _
    LECTURE ||--o{ LESSON : _
    
    LECTURE ||--|| LECTURE_ENROLLMENT : _
    LECTURE_ENROLLMENT ||--|| LECTURE_PROGRESS : _
    LECTURE_ENROLLMENT ||--|| ENROLLMENT: _

    SECTION ||--o{ LESSON : _

    ENROLLMENT }o--|| LECTURE : _

    LECTURE_PROGRESS ||--|| MEMBER : _
```
