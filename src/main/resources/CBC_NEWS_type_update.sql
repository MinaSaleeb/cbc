UPDATE `cbc_news`
SET `type` = CASE WHEN `video_url` IS NOT NULL AND `video_url` <> '' THEN 'VIDEO' ELSE 'NORMAL' END;
