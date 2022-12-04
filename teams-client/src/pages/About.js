import * as React from 'react';
import Button from '@mui/material/Button';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import CssBaseline from '@mui/material/CssBaseline';
import Grid from '@mui/material/Grid';
import Stack from '@mui/material/Stack';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import Spacing from "@components/Spacing";
import Title from "@components/Title";
import Paragraph from '@components/Paragraph';

const theme = createTheme();

export default function About() {

  const cards = [
    {
      header: "REST API",
      description: "A REST API that supports out chat functionality, implemented using Spring-boot, Spring-security & authentication, JWToken using a Postgres database.",
      path: "/projects/rest-api",
      image: "https://source.unsplash.com/random",
    }
  ]

  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <Spacing size={"5"}/>
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
              <Button variant="contained" onClick={()=>window.location = "/projects/chat"}>Contact us</Button>
              <Button variant="outlined" onClick={()=>{window.open('mailto:filipesantosdev@gmail.com,bvsantosdev@gmail.com')}}>Email us</Button>
            </Stack>
          </Container>
        </Box>
        <Container maxWidth="md" id={"our-projects"}>
          <Title size={3}>Our Projects</Title>
          <Grid container spacing={4}>
            {cards.map((card) => (
              <Grid item key={card} xs={12} sm={6} md={4}>
                <Card
                  sx={{ height: '100%', display: 'flex', flexDirection: 'column' }}
                >
                  <CardMedia
                    component="img"
                    image={card.image}
                    alt="random"
                  />
                  <CardContent sx={{ flexGrow: 1 }}>
                    <Title size={6}>{card.header}</Title>
                    <Paragraph size={9}>{card.description} </Paragraph>
                  </CardContent>
                  <center>
                    <Button size="small" onClick={()=>window.location = card.path}>View</Button>
                  </center>
                </Card>
              </Grid>
            ))}
          </Grid>
        </Container>
      </main>
      <Spacing size={"5"}/>
    </ThemeProvider>
  );
}