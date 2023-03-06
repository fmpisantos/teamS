import * as React from 'react';
import Button from '@mui/material/Button';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Grid from '@mui/material/Grid';
import Stack from '@mui/material/Stack';
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import Spacing from "@components/Spacing";
import Title from "@components/Title";
import Paragraph from '@components/Paragraph';

const theme = createTheme();

export default function About(props) {

  const cards = props.projects;

  return (
    <div className="row-100 scrollable">
      <ThemeProvider theme={theme}>
        <main>
          <Box
            sx={{
              bgcolor: 'background.paper',
              pt: 8,
              pb: 6,
            }}
          >
            <Container maxWidth="sm">
              <Title>TeamS</Title>
              <Paragraph>
                We are a team of two dedicated software engineers, each tasked with testing and improving the software we deliver. 
                We are constantly working on the inner core of our software to minimize bugs and make it more stable and reliable. 
                Our customer base consists of small, medium and large customers ranging from healthcare to enterprises to universities and entrepreneurial ideas.
              </Paragraph>
              <Stack
                sx={{ pt: 4 }}
                direction="row"
                spacing={2}
                justifyContent="center"
              >
                <Button variant="contained" onClick={props.showChat}>Contact us</Button>
                <Button variant="outlined" onClick={()=>{window.open('mailto:filipesantosdev@gmail.com,bvsantosdev@gmail.com')}}>Email us</Button>
              </Stack>
            </Container>
          </Box>
          <Container maxWidth="md" id={"our-projects"}>
            <Title size={3}>Our Projects</Title>
            <Spacing size={"5"}/>
            <Grid container spacing={4}>
              {cards.map((card) => (
                <Grid key={card} xs={12} sm={6} md={4} onClick={()=>{card.func ? card.func() : window.location = card.path}} className="cursorPointer _shadow padding-2">
                  <Card
                    sx={{ height: '100%', display: 'flex', flexDirection: 'column' }}
                  >
                    <CardMedia
                      component="img"
                      image={card.image}
                      alt={card.header}
                    />
                    <CardContent sx={{ flexGrow: 1 }}>
                      <Title size={6}>{card.header}</Title>
                      <Paragraph size={9}>{card.description} </Paragraph>
                    </CardContent>
                  </Card>
                </Grid>
              ))}
            </Grid>
          </Container>
        </main>
        <Spacing size={"5"}/>
      </ThemeProvider>
    </div>
  );
}